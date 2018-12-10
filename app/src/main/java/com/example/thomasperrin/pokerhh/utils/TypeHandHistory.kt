package com.example.thomasperrin.pokerhh.utils

enum class TypeHandHistory {

    MTT{
        override fun getTypeIntHH() = 0
        override fun getTypeNameHH() = "MTT"
    },
    SNG{
        override fun getTypeIntHH() = 1
        override fun getTypeNameHH() = "Sit N Go"
    },
    EXP{
        override fun getTypeIntHH() = 2
        override fun getTypeNameHH() = "Expresso"
    },
    CG{
        override fun getTypeIntHH() = 3
        override fun getTypeNameHH() = "Cash Game"
    };

    abstract fun getTypeIntHH(): Int
    abstract fun getTypeNameHH(): String

}