package com.eduardofbom;

import com.eduardofbom.exception.PostalCodeNotFoundException;
import com.eduardofbom.model.Address;
import com.eduardofbom.model.Menu;
import com.eduardofbom.query.ViaCepQuery;
import com.eduardofbom.utils.JsonSaver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regexPostalCode = "\\d{2}\\.?\\d{3}-?\\d{3}";
        Pattern pattern = Pattern.compile(regexPostalCode);

        List<Address> addressList = new ArrayList<>();
        String fileName = "addressList";

        Menu.showMessageWelcome();
        scanner.nextLine();
        while (true) {
            Menu.showMenu();
            Integer userOption = scanner.nextInt();
            Integer integerUseroption = Integer.valueOf(userOption);

            switch (userOption) {
                case 0:
                    break;
                case 1:
                    Menu.showQuestionPostalCode();
                    scanner.nextLine();
                    String userPostalCode = scanner.nextLine();
                    Matcher matcher = pattern.matcher(userPostalCode);
                    if (matcher.matches()) {
                        try {
                            String postalCode = matcher.group().replace(".", "").replace("-","");
                            ViaCepQuery viaCepQuery = new ViaCepQuery(postalCode);
                            Menu.showMessageSearchLoading();
                            Address address = viaCepQuery.query();
                            Menu.showMessageSearchFinish();
                            addressList.add(address);
                            Menu.showAddressDescription(address);
                        } catch (IllegalArgumentException e) {
                            Menu.showMessageInvalidPostalCodeFormat();
                        } catch (PostalCodeNotFoundException e) {
                            e.printStackTrace();
// criar um método estático na classe Menu com uma mensagem informando para o usuário que o cep que ele inseriu não foi achado
                        }
                    } else {
                        Menu.showMessageInvalidOption(userPostalCode);
                    }
                    scanner.nextLine();
                    break;
                case 2:
                    JsonSaver jsonSaver = new JsonSaver(fileName);
                    jsonSaver.save(addressList);
                    Menu.showSavedMessage(fileName);
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
                default:

                    break;
            }
            if(userOption == 0) {
                break;
            }


        }
        Menu.showExitMessage();

        scanner.close();
    }
}
