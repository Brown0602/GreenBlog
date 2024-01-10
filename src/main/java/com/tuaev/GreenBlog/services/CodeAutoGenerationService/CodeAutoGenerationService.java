package com.tuaev.GreenBlog.services.CodeAutoGenerationService;

import org.springframework.stereotype.Service;

@Service
public class CodeAutoGenerationService {

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
