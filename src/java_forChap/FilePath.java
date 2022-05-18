package java_forChap;


public enum FilePath {

    PATH("src/java_forChap/forFile");

    private final String path;

    FilePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

}
