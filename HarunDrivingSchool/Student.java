
public class Student
{
    private String name;
    private String icNo;
    private String telNo;
    private int age;
    private String address;
    private String type;

    public Student() { }

    public Student(String n, String iN, String tN, int aG, String a, String t)
    {
        name = n;
        icNo = iN;
        telNo = tN;
        age = aG;
        address = a;
        type = t;
    }

    public void setStudent(String n, String iN, String tN, int aG, String a, String t)
    {
        name = n;
        icNo = iN;
        telNo = tN;
        age = aG;
        address = a;
        type = t;
    }

    public String getName() { return name; }
    public String getIcNo() { return icNo; }
    public String getTelNo() { return telNo; }
    public int getAge() { return age; }
    public String getAddress() { return address; }
    public String getType() { return type; }

    public String toString()
    {
        return ("Name : " + name + "\nIC Number: " + icNo + "\nPhone Number: "
                + telNo + "\nAge: " + age + "\nAddress: " + address + "\nType:" + type);
    }
}
