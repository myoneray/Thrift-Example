namespace java com.demo.thrift.example
//namespace在java里面就是对应package，这里 namespace   java  com.demo，第二个关键字表示使用的语言
//一个service会对应生成一个类文件
service DemoService{

//根据id获取用户名
string getNameById(1:i32 id)

}
