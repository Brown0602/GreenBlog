package com.tuaev.GreenBlog.RegistrationNewUser.CodeAutoGeneration;

import org.springframework.stereotype.Repository;

@Repository
public class CodeAutoGeneration {

    public String codeAutoGeneration(){

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            double number = Math.random() * 9;
            int numberInt = (int)number;
            String numberString = String.valueOf(numberInt);
            stringBuilder.append(numberString);
        }

        String code = String.valueOf(stringBuilder);

        return code;
    }

}
