package pages;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.$$x;

import java.util.HashMap;
import java.util.Map;

public class ModalPage {
    
    //выбираем все значения таблицы
    ElementsCollection tdCollection = $$x("//div[@class='table-responsive']//tbody//td");

    //будет наполняться значениями таблицы
    Map<String, String> trElements = new HashMap<>();

    

    //заполняем карту элементами таблицы
    public void fillMapTable(){
        for(int i = 0; i < tdCollection.size(); i++){
            if(i%2 == 0){
                trElements.put((tdCollection.get(i).getOwnText()), (tdCollection.get(i + 1).getOwnText()));
            }       
        }
        System.out.println(trElements);
    }

    //получаем значение поля по ключу

    public String getMapTable(String key){
        return trElements.get(key);  
    }




    

}
