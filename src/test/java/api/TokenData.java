package api;

import lombok.Getter;

@Getter

public class TokenData {

    private String token;

    public TokenData(String token){
        this.token = token;
    }

    public TokenData(){}

} 
