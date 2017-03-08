package lightpath.com.ibuy.presentation.model.Entities;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LUIS on 04/03/2017.
 */
@IgnoreExtraProperties
public class Product {

        public String name;
        public String price;
        public String image;
        public String detail;
        public String size;
        public String colors;

        public Product() {
            // Default constructor required for calls to DataSnapshot.getValue(Post.class)
        }

        public Product(String name, String price,String image,String detail,String size,String colors) {
            this.name= name;
            this.price= price;
            this.image=image;
            this.detail=detail;
            this.size=size;
            this.colors=colors;
        }

        @Exclude
        public Map<String, Object> toMap() {
            HashMap<String, Object> result = new HashMap<>();
            result.put("name", name);
            result.put("price", price);
            result.put("image", image);
            result.put("detail", detail);
            result.put("size", size);
            result.put("colors", colors);
            return result;
        }
}
