package com.yonyou.post.impl;

import com.yonyou.post.api.PostQueryService;
import com.yonyou.post.dto.PostDTO;
import com.yonyou.post.po.Post;
import com.yonyou.post.service.PostService;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.iuap.ucf.dao.support.SqlParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RPC provider端
 * @author  
 * @date 2019-9-10 19:59:15
 */
@Service("com.yonyou.post.impl.PostQueryServiceImpl")
public class PostQueryServiceImpl implements PostQueryService {

    private PostService postService;

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }


    @Override
    public List<PostDTO> listPost(SearchParams searchParams) {
        List<Post>  list = postService.queryList(searchParams);
        List<PostDTO> result = new ArrayList<>();
        if (list!=null){
            for (Post model:list){
                PostDTO dto = new PostDTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
