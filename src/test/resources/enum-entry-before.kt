enum class Operation {
    ADD {
        override fun apply(a: Int, b: Int): Int = a + b
    },
    SUBTRACT {
        override fun apply(a: Int, b: Int): Int = a - b
    },
    MULTIPLY {
        override fun apply(a: Int, b: Int): Int = a * b
    },
    /**
     * One.
     */
    DIVIDE {
        /**
         * Two.
         */
        override fun apply(a: Int, b: Int): Int = a / b
    };
    /**
     * Three.
     */
    abstract fun apply(a: Int, b: Int): Int
}
