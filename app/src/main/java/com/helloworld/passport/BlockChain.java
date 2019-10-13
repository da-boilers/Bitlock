package com.helloworld.passport;

import com.helloworld.passport.util.Block;

import java.util.ArrayList;
import java.util.List;

public class BlockChain {
    public ArrayList<Block> blockList = new ArrayList<Block>();

    public BlockChain (ArrayList<Block> blockList){
        this.blockList = blockList;
    }
}
