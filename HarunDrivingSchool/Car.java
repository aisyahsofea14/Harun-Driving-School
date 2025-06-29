
public class Car extends classLicense
{
    public Car(String t, Student stud, String c)
    {
        super(t, stud, c);
    }

    public double determineFee()
    {
        double fee = 0;
        if (super.getCode().equalsIgnoreCase("D"))
            fee = 1800;
        else if (super.getCode().equalsIgnoreCase("DA"))
            fee = 2000;
        return fee;
    }

    public double totalPayment()
    {
        return determineFee() + super.calcTransport();
    }
}
