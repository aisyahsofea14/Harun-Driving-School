
import java.text.DecimalFormat;

abstract public class classLicense
{
    protected String transport;
    protected Student stud;
    protected String code;
    DecimalFormat df = new DecimalFormat("0.00");

    public classLicense() { }

    public classLicense(String t, Student stud, String c)
    {
        transport = t;
        this.stud = stud;
        code = c;
    }

    public String getCode() { return code; }
    public Student getStudent() { return stud; }
    public String getTransport() { return transport; }

    abstract double determineFee();
    abstract double totalPayment();

    public double calcTransport()
    {
        double addCharge;
        if (transport.equalsIgnoreCase("yes"))
            addCharge = 50;
        else
            addCharge = 0;
        return addCharge;
    }

    public String toString()
    {
        return ("Fee: RM " + df.format(determineFee())
                + "\nTotal Payment: RM " + df.format(totalPayment()));
    }
}
