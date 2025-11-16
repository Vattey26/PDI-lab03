public class Student {
    String name;
    int ID;
    String major;

    Student(){
        
    }
    Student(String newname, int ID, String major) {
        name = newname;
        this.ID = ID;
        this.major = major;
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + ID);
        System.out.println("Major: " + major);
    }
    public void setUpdateName(String name) {
        this.name = name;
    }

    public void setUpdateID(int ID) {
        this.ID = ID;
    }

    public void setUpdateMajor(String major) {
        this.major = major;
    }
}
