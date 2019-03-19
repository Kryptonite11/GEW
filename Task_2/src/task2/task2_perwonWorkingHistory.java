package task2;

public final class task2_perwonWorkingHistory
{


    private final String workingHistory;




    public String getWorkingHistory()
    {
        return workingHistory;
    }

    // Immutable, so no set methods


    public task2_perwonWorkingHistory(String personQualification)
    {
        this.workingHistory = personQualification;
    }


}