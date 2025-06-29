
public class Motorcycle extends classLicense
{
    public Motorcycle(String t, Student stud, String c)
    {
        super(t, stud, c);
    }

    public double determineFee()
    {
        double fee = 0;
        if (super.getCode().equalsIgnoreCase("B"))
            fee = 800;
        else if (super.getCode().equalsIgnoreCase("B2"))
            fee = 500;
        return fee;
    }

    public double totalPayment()
    {
        return determineFee() + super.calcTransport();
    }
}
