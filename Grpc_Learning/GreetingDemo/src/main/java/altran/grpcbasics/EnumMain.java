/*
  Created by  : Vivek Kumar
  Created on  : 30/06/2020
  Purpose     : proto file for enum example.
 */
package altran.grpcbasics;

import altran.protobuf.EnumExample;

class EnumMain {
    public static void main(String[] args) {

        //Creating Object for Enum protobuf.
        EnumExample.EnumMessage.Builder builder = EnumExample.EnumMessage.newBuilder();
        builder.setDayOfTheWeek(EnumExample.DayOfTheWeek.WEDNESDAY);
        EnumExample.EnumMessage message = builder.build();
        System.out.println(message);
    }
}
