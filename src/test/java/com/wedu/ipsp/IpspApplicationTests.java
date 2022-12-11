package com.wedu.ipsp;

import com.wedu.ipsp.service.modService.ModService;
import com.wedu.ipsp.service.idenService.idenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IpspApplicationTests {

    private idenService idenService;
    @Autowired
    private ModService modService;
    @Test
    void contextLoads() {
//        List<Mod> mods = modService.FindAllMod();
//
//        System.out.println(mods);
    }

}
