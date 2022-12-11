package com.wedu.ipsp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import xin.altitude.cms.common.lang.ITreeEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Mod  implements ITreeEntity<Integer> {
     int typeId;
     String typeName;
     int typeParentId;
     int level;

     @Override
     public Integer getId() {
          return typeId;
     }

     @Override
     public String getName() {
          return typeName;
     }

     @Override
     public Integer getParentId() {
          return typeParentId;
     }
//     List<Mod> modTrees =new ArrayList<>();


}
