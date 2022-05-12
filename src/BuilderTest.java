public class BuilderTest {
    private Long orderId;
    private String orderName;
    private Builder builder;

    public Builder getBuilder(Long orderId) {
        return new Builder(orderId);
    }


    BuilderTest(){}

    public static class Builder {
        private final Long orderId;
        private String orderName;

        public Builder(Long id) {
            this.orderId = id;
        }

        public Builder order(String orderName) {
            this.orderName = orderName;
            return this;
        }

        public BuilderTest build() {
            BuilderTest build = new BuilderTest();
            build.orderId = this.orderId;
            build.orderName = this.orderName;
            return build;
        }
    }
}
