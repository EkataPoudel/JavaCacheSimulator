/* ****************************************
 *  Author : Ekata Poudel   
 *  Created On : Fri Sep 20 2024
 *  File : CacheEntry.java
 *  Description:
 * THis is the class CacheEntry which live in the package cache
 * This class has two attributes which is private. They are :
 * - name: String (Name of the Domain)
 * - value: String (IP address)
 * 
 * This class has public methods as follows
 * +CacheEntry(name:String, value:String):
 * +getName():String:
 * +getValue():String
 * +setName(name:String):void
 * +setValue(value:String):void
 * +toString():String
 *
 * ******************************************/

public class CacheEntry {
    private String name;
    private String value;

    public CacheEntry(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Name:" + name + "  Value: " + value + "";
    }

}