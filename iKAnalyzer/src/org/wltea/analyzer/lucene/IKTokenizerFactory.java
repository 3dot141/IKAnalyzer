package org.wltea.analyzer.lucene;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;

import java.util.Map;

/**
 * @description 用于配置文件中，分析器加分词器的配置
 */
public final class IKTokenizerFactory extends TokenizerFactory {
    private boolean useSmart;

    /**
     * @param args
     */
    public IKTokenizerFactory(Map<String, String> args) {
        //父类构造器
        super(args);
        //从 map 集合中 找出相应的 useSmart 值
        //如果没有， 就默认为 false
        useSmart = this.getBoolean(args, "useSmart", false);
        if (!args.isEmpty()) {
            throw new IllegalArgumentException("Unknown parameters:" + args);
        }
    }

    /**
     * @description 创建Tokenizer
     * @param attributeFactory
     * @return
     */
    @Override
    public Tokenizer create(AttributeFactory attributeFactory) {
        return new IKTokenizer(attributeFactory, useSmart);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
