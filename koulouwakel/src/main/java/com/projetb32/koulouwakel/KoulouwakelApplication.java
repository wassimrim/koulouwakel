package com.projetb32.koulouwakel;

import com.projetb32.koulouwakel.entity.Fridge;
import com.projetb32.koulouwakel.entity.FridgeIngredientGroup;
import com.projetb32.koulouwakel.entity.Ingredient;
import com.projetb32.koulouwakel.repository.FridgeRepository;
import com.projetb32.koulouwakel.repository.IngredientRepository;
import com.projetb32.koulouwakel.repository.UserRepository;
import com.projetb32.koulouwakel.service.FridgeIngredientGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class KoulouwakelApplication {

//    @Autowired
//    private FridgeRepository fridgeRepository;
//
//    private static final Logger log = LoggerFactory.getLogger(KoulouwakelApplication.class);

    public static void main(String[] args) throws Exception {

        SpringApplication.run(KoulouwakelApplication.class, args);
     /* KoulouwakelApplication k = new KoulouwakelApplication();
      k.run();*/

    }
   /* @Bean
    CommandLineRunner start (FridgeIngredientGroupService  fridgeIngredientGroupService){
       FridgeIngredientGroup fridgeIngredientGroup= fridgeIngredientGroupService.addIngredientToFridge(Long.valueOf(1),Long.valueOf(1));
          System.out.println("ahahahahaaha"+fridgeIngredientGroup.getPrimaryKey());
       return null;
    }*/


    /*public void run(String [] args) throws Exception {

        fridgeRepository.findRecipe(Long.valueOf(1));
        log.info("ssssqq");
    }*/
    //@Bean
   // CommandLineRunner Start(FridgeRepository fridgeRepository , UserRepository userRepository , IngredientRepository ingredientRepository) {
      //  log.info("dd "+ fridgeRepository.findRecipe(Long.valueOf(1)));
        //List <Ingredient> ingredients = new ArrayList<>();
        //ingredients.add( ingredientRepository.findById(Long.valueOf(3)).get());
       // fridgeRepository.save(new Fridge("name",userRepository.findById(Long.valueOf(2)).get(),ingredients));
       // fridgeRepository.findById(Long.valueOf(1)).get().getIngredients().forEach(ing->{log.info("3assbaaa"+ing.getName());});
        //log.info("wow"+fridgeRepository.findById(Long.valueOf(1)).get().toString());/*.get().getIngredients().toString());/*forEach( (i) -> {log.info("wow"+i.getName());}*/;
   //     return args -> {

          //  fridgeRepository.findRecipe(Long.valueOf(1));

            //   iservice.addRole(roleKofti);
            //  iservice.addUser("toto8", "123","taoufik.yazidi@gmail.com");
      //  };

   // }
}
