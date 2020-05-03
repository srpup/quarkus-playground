package edu.debis.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class ISBN {

    @Getter @Setter
    private String code, area, publisher;

    public ISBN(Builder builder) {
        this.code = builder.code;
        this.area = builder.area;
        this.publisher = builder.publisher;
    }

    public static class Builder {

        private final String code, area, publisher;

        public Builder(String code, String area, String publisher) {
            this.code = code;
            this.area = area;
            this.publisher = publisher;
        }

        public ISBN build() {
            ISBN isbn =  new ISBN(this);
           // System.out.println("isbn = " + isbn);
            return isbn;
        }
    }
}
