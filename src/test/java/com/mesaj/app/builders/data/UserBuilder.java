package com.mesaj.app.builders.data;

import com.mesaj.app.enums.Gender;
import com.mesaj.app.models.User;
import com.mesaj.app.util.RandomNumberGenerator;

public class UserBuilder {

    private User user;

    private UserBuilder(){
        user  = User.builder().build();
    }

    public static UserBuilder anUser(){
        return new UserBuilder();
    }

    public UserBuilder but(){
        return withDefaultInfo();
    }

    public UserBuilder withDefaultInfo() {
        this.user = User.builder()
                .firstName("Pepito")
                .lastName("Perez")
                .email("perez@gmail.com")
                .gender(Gender.male)
                .country("Japan")
                .birthDay("10")
                .birthMonth("February")
                .birthYear("1989")
                .phone(RandomNumberGenerator.get())
                .password("123")
                .passwordConfirmation("123")
                .build();
        return this;
    }

    public UserBuilder withoutEmail(){
        user.setEmail("");
        return this;
    }

    public UserBuilder withoutBirthDay(){
        user.setBirthDay("");
        return this;
    }

    public UserBuilder withoutBirthMonth(){
        user.setBirthMonth("");
        return this;
    }

    public User build(){
        return this.user;
    }
}
