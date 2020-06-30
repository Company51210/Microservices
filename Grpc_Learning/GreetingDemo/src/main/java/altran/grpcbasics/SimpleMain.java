/*
  Created by  : Vivek Kumar
  Created on  : 30/06/2020
  Purpose     : proto file
*/
package altran.grpcbasics;

import altran.protobuf.Simple;

import java.util.Arrays;

public class SimpleMain {
    public static void main(String[] args) {

        //Creating Object for simple message protobuf.
        Simple.SimpleMessage.Builder builder = Simple.SimpleMessage.newBuilder();

        //set the simple fields
        builder.setId(100)          //set id field
                .setIsSimple(true)   //set is_simple
                .setName("Simple message name : Vivek"); //set name

        //set repeated fields
        builder.addSampleList(10)
                .addSampleList(11)
                .addSampleList(12);

        builder.addAllSampleList(Arrays.asList(13,14,15));
        builder.setSampleList(1,30);
        System.out.println(builder.toString());
        System.out.println(builder.getSampleList(5));

        Simple.SimpleMessage message = builder.build();
        System.out.println(message.getId());

    }
}
