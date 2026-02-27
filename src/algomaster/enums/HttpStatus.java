package algomaster.enums;

import java.util.Arrays;

public enum HttpStatus {
    OK(200, "OK"), BAD_REQUEST(400, "Bad Request"), NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private int code;
    private String message;

    private HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public boolean isSuccess() {
        return (this.code < 400);
    }

    public void display() {
        System.out.println(this.code + " " + this.message);
    }

    public static HttpStatus fromCode(int code) {
        return Arrays.stream(HttpStatus.values()).filter(status -> status.code == code).findFirst().orElseGet(null);
    }

    public static void main(String[] args) {
        HttpStatus.OK.display();
        HttpStatus.NOT_FOUND.display();

        System.out.println("Is 200 success? " + HttpStatus.OK.isSuccess());
        System.out.println("Is 404 success? " + HttpStatus.NOT_FOUND.isSuccess());

        HttpStatus found = HttpStatus.fromCode(500);
        if (found != null) {
            System.out.print("Found by code 500: ");
            found.display();
        }
    }
}
