package uk.ac.reading.gm013960.overwatchrawsoundfiles;

public enum Hero {

    BASTION("Files 1-100", "0"), DVA("Files 101-200", "1"),
    GENJI("Files 201-300", "2"), HANZO("Files 301-400", "3"),
    JUNKRAT("Files 401-500", "4"), LUCIO("Files 501-600", "5"),
    MCCREE("Files 601-700", "6"), MEI("Files 701-800", "7"),
    MERCY("Files 801-900", "8"), PHARAH("Files 901-1000", "9");

    private String name, dir;

    Hero(String displayedName, String directoryName) {
        name = displayedName;
        dir = directoryName;
    }

    public String getName() {
        return name;
    }

    public String getDir() {
        return dir;
    }
}
