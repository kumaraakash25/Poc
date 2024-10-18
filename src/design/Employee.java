package design;


public class Employee {

    private Long id;

    Employee(EmployeeBuilder builder) {
        this.id = builder.id;
    }

    public static void main(String[] args) {
        Employee e = new Employee.EmployeeBuilder().
                setId(1L).build();
    }

    static class EmployeeBuilder {

        private Long id;

        public EmployeeBuilder setId(Long id) {
            this.setId(id);
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }

    }
}
