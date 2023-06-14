public class Employee {
    private Long id;
    private String name;
    public Employee(EmployeeBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    static class EmployeeBuilder {
        private Long id;
        private String name;
        public EmployeeBuilder id(Long id) {
            this.id = id;
            return this;
        }
        public EmployeeBuilder name(String name) {
            this.name = name;
            return this;
        }
        public Employee build() {
            return new Employee(this);
        }
    }

    public static void main(String[] args) {
        Employee employee = new Employee.EmployeeBuilder().id(1L).name("Test").build();
    }
}