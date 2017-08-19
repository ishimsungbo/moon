package com.moon.sample.ctr;

import com.moon.sample.mapper.ComMapper;
import com.moon.sample.persistent.BoardRepository;
import com.moon.sample.vo.Board;
import com.moon.sample.vo.Useres;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/sample/")
@Api(value = "샘플컨트롤러")
public class SamController {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    BoardRepository boardRepository;

    @Resource(name="ComMapper")
    private ComMapper comMapper;

    @ApiOperation(value = "유저정보",notes = "스웨거 Vo 샘플적용")
    @RequestMapping(value = "getUserlist",method = RequestMethod.GET)
    public List<Map<String,Object>> getUser(){
        List<Map<String,Object>> useresList = comMapper.getUserMapList();
        return useresList;
    }

    @ApiOperation(value = "유저만들기",notes = "스웨거 Vo 샘플적용")
    @RequestMapping(value = "createUser",method = RequestMethod.POST)
    public String userInsert(@RequestBody Useres useres){

        logger.info("전달된 값은 : "+useres.toString());
        return "users Createve";
    }

    @ApiOperation(value = "보더가져오기",notes = "스웨거 Vo 샘플적용")
    @RequestMapping(value = "getboardlist",method = RequestMethod.GET)
    public List<Board>  test(){

        /*
        boardRepository.save(new Board("오늘의 주제는 음식","음식에 대해 알아보아요"));
        boardRepository.save(new Board("오늘의 주제는 운동","운동에 대해 알아보아요"));
        boardRepository.save(new Board("오늘의 주제는 음악","음악에 대해 알아보아요"));
        */


        //이터레이터 사용
        Iterable<Board> iterable = boardRepository.findAll();

        List<Board> boards = new ArrayList<>();

        for(Board board : iterable){
            logger.info("가져온 값은 : "+board.toString());
            boards.add(board);
        }

        return boards;
    }

    @ApiOperation(value = "RequestParam 넘기기",notes = "인터셉터 테스트")
    @RequestMapping(value = "net",method = RequestMethod.GET)
    public String net(@RequestParam String name){
        logger.info("Controller : " + name.toString());
        return "ok";
    }
}
