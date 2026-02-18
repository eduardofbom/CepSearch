package com.eduardofbom.model;

public class Menu {
    public static void showWelcomeMessage() {
        System.out.println("""
                ====================================
                   WELCOME TO POSTAL CODE SEARCH!   
                ====================================
                  (press any key to view the menu)
                """);
    }
    public static void showMenu() {
        System.out.print("""
                
                ##########################
                     CHOOSE A OPTION:
                --------------------------
                 1 - Query a postal code
                 2 - Update Json file
                 0 - Exit program
                --------------------------
                => """);
    }

    public static void showInvalidUserInputMessage() {
        System.out.println("""
                ==================================
                           INVALID INPUT
                ----------------------------------
                  The postal code must contain 8
                  digits!
                ==================================
                 (press any key to view the menu)""");
    }

    public static void showQuestionPostalCode() {
        System.out.print("""
                
                ##############################
                      POSTAL CODE SEARCH
                ------------------------------
                 Enter the postal code you wish to
                 search below [without symbols].
                 => """);
    }

    public static void showSearchLoadingMessage() {
        System.out.println("""
                Searching postal code...
                """);
    }

    public static void showSearchFinishMessage() {
        System.out.println("""
                
                ====================
                  Your postal code
                  has been found!
                ====================""");
    }

    public static void showAddressDescription(Address address) {
        System.out.printf("""
                
                **************************************************
                               ADDRESS DESCRIPTION
                --------------------------------------------------
                 Postal Code: %s
                 Thoroughfare: %s
                 Neighborhood: %s
                 City: %s
                 State: %s
                 Region: %s
                 Area Code: %s%n
                **************************************************
                         (press any key to view the menu)""",
                address.getPostalCode(),
                address.getThoroughfare(),
                address.getNeighborhood(),
                address.getCity(),
                address.getState(),
                address.getRegion(),
                address.getAreaCode());
    }

    public static void showSavedMessage(String fileName) {
        System.out.printf("""
                ======================================
                  Your postal code list was updated,
                  check in file"%s".
                ======================================
                   (press any key to view the menu)%n""", fileName);
    }

    public static void showExitMessage() {
        System.out.println("""
                
                ==================================
                  Thank you for using our postal
                  code search tool!
                                        Bye bye!
                ==================================""");
    }
}
