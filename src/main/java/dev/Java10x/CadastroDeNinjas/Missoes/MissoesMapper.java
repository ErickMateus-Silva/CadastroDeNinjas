package dev.Java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO missoesDTO) {
        MissoesModel missoesModel = new MissoesModel();
        missoesModel.setId(missoesDTO.getId());
        missoesModel.setDificuldade(missoesDTO.getDificuldade());
        missoesModel.setNome(missoesDTO.getNome());
        missoesModel.setNinja(missoesDTO.getNinja());

        return missoesModel;
    }

    public  MissoesDTO map(MissoesModel missoesModel){
        MissoesDTO  missoesDTO = new MissoesDTO();
        missoesDTO.setId(missoesModel.getId());
        missoesDTO.setDificuldade(missoesModel.getDificuldade());
        missoesDTO.setNome(missoesModel.getNome());
        missoesDTO.setNinja(missoesModel.getNinja());

        return missoesDTO;
    }
}
