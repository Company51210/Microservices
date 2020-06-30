/*
  Created by  : Vivek Kumar
  Created on  : 30/06/2020
  Purpose     : proto file
 */

package altran.address.example;

import altran.address.protobuf.Addressbook;

public class AddressMain {
    public static void main(String[] args) {
        //Creating a Number Instance
        Addressbook.Person.PhoneNumber.Builder mobNum = Addressbook.Person.PhoneNumber.newBuilder();
        mobNum.setType(Addressbook.Person.PhoneType.WORK)
                .setNumber("901517").build();

        //Creating a Person and adding the Number
        Addressbook.Person.Builder person = Addressbook.Person.newBuilder();
        person.setId(101)
                .setName("vivek")
                .setEmail("vivek@gmail.com")
                .addPhones(mobNum).build();

        //Creating a Address instance and adding the person Instance
        Addressbook.AddressBook.Builder address = Addressbook.AddressBook.newBuilder();
        address.addPeople(person);
        address.build();
        System.out.println(address);
    }

}
