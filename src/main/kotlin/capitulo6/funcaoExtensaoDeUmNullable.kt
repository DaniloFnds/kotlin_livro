package capitulo6


 fun verifyUserInput(input: String?) {
    if(input.isNullOrBlank()) {
        println("Please fill in th required fields")
    }


}

fun exec7() {
    verifyUserInput(" ")
    //please fill in the reqired
    verifyUserInput(null)
    //please fill in the required
}