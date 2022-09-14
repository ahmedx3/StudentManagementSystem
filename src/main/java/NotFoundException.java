public class NotFoundException extends Exception {

    NotFoundException() {
    }

    NotFoundException(String type, int id) {
        super(type + " with id " + id + " not found");
    }
}
