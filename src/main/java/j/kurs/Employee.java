package j.kurs;

public class Employee {
    // create employees with different roles and add them to the company give them a unique security id the id goes from 1-5 and is used to check if they have access to that area
    private String firstName;
    private String lastName;
    private int securityId;
    final private String role;

    public Employee(String firstName, String lastName, int securityId, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.securityId = securityId;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSecurityId() {
        return securityId;
    }
    
    public void setSecurityId(int securityId) {
        this.securityId = securityId;
    }

    public String getRole() {
        return role;
    }

    // create 5 rolles with different access levels
    public boolean hasAccessTo(int securityId) {
        //do it with switch case instead if else
         switch (securityId) {
        case 1:
         return true;
        case 2:
         return true;
        case 3:
         return true;
        case 4:
         return true;
        case 5:
         return true;
        default:
            return false;
        }
    }

    @Override
    public String toString() {
        return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + ", securityId="
                + securityId + "]";
    }

}
