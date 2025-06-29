
public class Lorry extends classLicense
{
    public Lorry(String t, Student stud, String c)
    {
        super(t, stud, c);
    }

    public double determineFee()
    {
        double fee = 0;
        if (super.getCode().equalsIgnoreCase("E"))
            fee = 1900;
        return fee;
    }

    public double totalPayment()
    {
        return determineFee() + super.calcTransport();
    }
}
