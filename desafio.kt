// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)
enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

class AlreadyRegisteredException(message: String) : Exception(message)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        val regex = Regex(usuario.nome)
        val result = inscritos.filter { regex.containsMatchIn(it.nome) }
        if (result.size == 0) {
        	inscritos.add(usuario)
            println("Usuário ${usuario.nome} inscrito com sucesso")
        } else {
            throw AlreadyRegisteredException("Usuário ${usuario.nome} já foi incrito na formação")
        }
        
    }
}

fun main() {
    
    val localStorage = ConteudoEducacional(nome = "Local Storage", nivel = Nivel.INTERMEDIARIO)
    val asynchronously = ConteudoEducacional(nome = "Async / Await", nivel = Nivel.INTERMEDIARIO)
    val closure = ConteudoEducacional(nome = "Closure", nivel = Nivel.AVANCADO)
    val classes = ConteudoEducacional(nome = "Classes", nivel = Nivel.INTERMEDIARIO)
    
    val content = listOf(localStorage, asynchronously, closure, classes)
    
    val javascript = Formacao("Javascript profissional", content)
    
    val user1 = Usuario("Arthur")
    val user2 = Usuario("Diego")    
    val user3 = Usuario("Nicolas")    
    val user4 = Usuario("Jin Ho")    
    val user5 = Usuario("Luiz")    
    val user6 = Usuario("Jorge Ben")
    
    javascript.matricular(user1)
    javascript.matricular(user2)
    javascript.matricular(user3)
    javascript.matricular(user4)
    javascript.matricular(user5)
    javascript.matricular(user6)
    
    println(javascript.inscritos)
    
}