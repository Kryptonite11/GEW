package task2;

public final class task2_personQualifications
{


    private final String qualification;




    public String getQualification()
    {
        return qualification;
    }

    // Immutable, so no set methods


    public task2_personQualifications(String personQualification)
    {
        this.qualification = personQualification;
    }


}