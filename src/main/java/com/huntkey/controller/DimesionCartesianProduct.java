package com.huntkey.controller;

import com.huntkey.dto.DimesionDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by liuwens on 2017/7/29.
 */
@RestController
@RequestMapping("/dimesion")
public class DimesionCartesianProduct
{

    /**
     * 根据维度组合计算总的cuboid
     * @param dimesionELValue  维度参数表达式格式：A:9-B:3-C:3
     * @return
     */
    @RequestMapping("/test/{dimesionEL}")
    public List test(@PathVariable("dimesionEL") String dimesionELValue)
    {
        //A:9-B:3-C:3
        String[] dimesionParamObjList = dimesionELValue.split("-");


        //String[] str = {"A" , "B" ,"C", "D", "E", "F"};

        //生成维度参数对象，包括维度名称和维度层级数量
        List<DimesionDTO> dimesionDTOList = createDimesionList(dimesionParamObjList);

        int n = dimesionDTOList.size();                                  //元素个数。
        //求出位图全组合的结果个数：2^n
        int nbit = 1 << n;                                     // “<<” 表示 左移:各二进位全部左移若干位，高位丢弃，低位补0。:即求出2^n=2Bit。

        //System.out.println("全组合结果个数为：" + nbit);

        List<String> dimesionCartList = new ArrayList<>();

        for(int i = 0 ;i < nbit ; i++)
        {                        //结果有nbit个。输出结果从数字小到大输出：即输出0,1,2,3,....2^n。
            //System.out.print("组合数值  "+i + " 对应编码为： ");

            StringBuffer buffer = new StringBuffer();
            for(int j = 0; j < n ; j++)
            {
                //每个数二进制最多可以左移n次，即遍历完所有可能的变化新二进制数值了
                int tmp = 1 << j ;
                if((tmp & i) != 0)
                {
                    buffer.append("-");
                    //& 表示与。两个位都为1时，结果才为1
                    buffer.append(dimesionDTOList.get(j).getDimesionName());
                }
            }

            buffer.replace(0, 1, "");

            dimesionCartList.add(buffer.toString());
        }

        long totalCuboidValue = 0;

        List<String> list = new ArrayList<>();

        //计算所有组合的总cuboid和
        for (int index = 0; index < dimesionCartList.size(); index++)
        {
            List<Integer> dimesionLevelValueList = new ArrayList<>();

            String dimesionStr = dimesionCartList.get(index);

            StringTokenizer dimesionStrToken = new StringTokenizer(dimesionStr,"-");
            while(dimesionStrToken.hasMoreTokens())
            {
                String dimesionName = dimesionStrToken.nextToken();

                DimesionDTO dimesionDTO = getDimesionObj(dimesionDTOList, dimesionName);

                dimesionLevelValueList.add(dimesionDTO.getDimesionLevelValue());

            }

            long value = 1;

            //计算一个维度组合的cuboid值
            for(int levelIndex = 0; levelIndex < dimesionLevelValueList.size(); levelIndex++)
            {
                value *= dimesionLevelValueList.get(levelIndex);
            }

            if(dimesionStr != null && !"".equals(dimesionStr) && dimesionStr.length() > 0)
            {
                //累计所有维度组合下的cuboid
                totalCuboidValue += value;

                //有效维度
                list.add("维度树组合值:" + dimesionStr + "; 维度层级组合数:" + value);
            }
        }

        list.add("维度树组合总数:" + list.size() + "; 维度层级组合数:" + totalCuboidValue);

        return list;
    }

    private DimesionDTO getDimesionObj(List<DimesionDTO> dimesionDTOList, String dimesionName)
    {
        for(DimesionDTO dimesion : dimesionDTOList)
        {
            if(dimesionName.equals(dimesion.getDimesionName()))
            {
                return dimesion;
            }
        }

        return null;
    }

    private List<DimesionDTO> createDimesionList(String[] dimesionStrList)
    {
        List<DimesionDTO> dimesionDTOList = new ArrayList();

        for(int index = 0; index < dimesionStrList.length; index++)
        {
            String dimesionParamObj = dimesionStrList[index];

            //A:9  维度名称:维度层级数
            String[] paramList = dimesionParamObj.split(":");

            DimesionDTO dimesionDTO = new DimesionDTO(paramList[0], Integer.valueOf(paramList[1]));
            dimesionDTOList.add(dimesionDTO);
        }

        return dimesionDTOList;
    }




}
