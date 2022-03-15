package com.company;

public class REQUESTS_MENU extends MENU {
    REQUEST[] Request_List;
    REQUEST[] Chosen_Request;

    public REQUESTS_MENU(){
        REQUEST[] Request_LIst ;
    }

    public static void Display_requests_menu() {

    }


    public REQUESTS_MENU(REQUEST[] request_List) {
        Request_List = request_List;
    }

    public boolean Can_Be_Displayed() {
        return Request_List != null && Request_List.length != 0;
    }

    public void Choose_Request() {

    }

    public static void Display_Requests() {

    }


    public void Choose_Request(int Request_Choice){

    }
}
