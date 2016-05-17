package uk.ac.reading.gm013960.overwatchrawsoundfiles;

public enum Range {

    _0("0", "1-1000"), _1("1", "1001-2000"), _2("2", "2001-3000"), _3("3", "3001-4000"),
    _4("4", "4000-5000"), _5("5", "5001-6000"), _6("6", "6001-7000"), _7("7", "7001-8000"),
    _8("8", "8001-9000"), _9("9", "9001-10000"), _10("10", "10001-11000"), _11("11", "11001-12000"),
    _12("12", "12001-13000"), _13("13", "13001-14000"), _14("14", "14001-15000"),
    _15("15", "15001-16000"), _16("16", "16001-17000"), _17("17", "17001-18000"),
    _18("18", "18001-19000");

    private String dir, name;

    Range(String directoryName, String displayedName) {
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
