package.com.myProject
// 패키지의 경우 모두 소문자 이때 
// 여러개의 단어를 동시에 쓰려면 _ 가 아닌 CamelCase

object MyCategories
// 클래스와 오브젝트는 대문자시작, CamelCase
val PersonComparator = Comparator<Person>
// 다음과 같이 싱글톤으로 쓰이게될 객체도 대문자시작, CamelCase

private const val MARKET_LINK = "http://play.google.com/store/apps/details?id="
// SCREAMING SNKAE CASE
// 이외에 const 말고도 top level 변수의 경우에도 SCREAMING SNKAE CASE 

fun myFunction
// 함수,변수의 경우 소문자시작, CamelCase

private val _peopleList = mutableListOf<Int>()
val peopleList: List<Int> get() = _peopleList
// 백킹 프로퍼티의 경우 가변속성을 _로 표현

interface function
class functionImpl : function
// 구현체 경우에는 Impl을 뒤에 붙여준다. 

fun sample(a: Int, b: Int, c: Int) {}
sample(a = 1, b = 2,c = 3)
// 매개변수가 세개이상일 경우 named parameter 해주면 좋음

val a = (1 + 2 + 3)
// 연산자의 경우 각 항마다 공백을 넣어준다.
