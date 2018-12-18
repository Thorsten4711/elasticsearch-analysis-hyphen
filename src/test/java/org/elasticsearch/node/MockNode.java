package org.elasticsearch.node;

import java.util.ArrayList;
import java.util.Collection;

import org.elasticsearch.common.logging.LogConfigurator;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.plugins.Plugin;

/**
 *
 */
public class MockNode extends Node {

    public MockNode(Settings settings, Collection<Class<? extends Plugin>> classpathPlugins) {
        super(InternalSettingsPreparer.prepareEnvironment(settings, null), classpathPlugins, false);
    }

    public MockNode(Settings settings, Class<? extends Plugin> classpathPlugin) {
        this(settings, list(classpathPlugin));
    }

    public MockNode(Settings settings) {
        this(settings, list());
    }

    private static Collection<Class<? extends Plugin>> list() {
        return new ArrayList<>();
    }

    private static Collection<Class<? extends Plugin>> list(Class<? extends Plugin> classpathPlugin) {
        Collection<Class<? extends Plugin>> list = new ArrayList<>();
        list.add(classpathPlugin);
        return list;
    }

    @Override
    protected void registerDerivedNodeNameWithLogger(String nodeName) {
        LogConfigurator.setNodeName(nodeName);
    }
}
