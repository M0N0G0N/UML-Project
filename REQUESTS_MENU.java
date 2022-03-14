package com.company;

public class REQUESTS_MENU extends MENU {
    REQUEST[] Request_List;
    REQUEST[] Chose_Request;

    public REQUESTS_MENU(){
        REQUEST[] Request_LIst ; 

    }


    public REQUESTS_MENU(REQUEST[] request_List) {
        Request_List = request_List;
    }

    public boolean Can_Be_Displayed() {
        if (Request_List.length == 0 ) {
            return false  ; 
        }
        else return true;
    }

    public REQUEST Choose_Request() {
        return REQUEST;
    }

    public int Display_Requests() {

    }

    public void Choose_Request(int Request_Choice){

    }
}
