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
        System.out.println("""
                
                ##########################
                     CHOOSE A OPTION:
                --------------------------
                 1 - Query a postal code
                 2 - Update Json file
                 3 - Exit program
                --------------------------
                => """);
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

    public static void showSearchMessage() {
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
                **************************************************""",
                address.getPostalCode(),
                address.getThoroughfare(),
                address.getNeighborhood(),
                address.getCity(),
                address.getState(),
                address.getRegion(),
                address.getAreaCode());
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
