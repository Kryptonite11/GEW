package task2;

public final class task2_personDetails
{


    private final String name;
    private final String surname;
    private final int age;




    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public int getAge()
    {
        return age;
    }


    // Immutable, so no set methods


    public task2_personDetails(String personName, String personSurname, int personAge)
    {
        this.name = personName;
        this.surname = personSurname;
        this.age = personAge;
    }


}

