package run.halo.app.utils;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Filename utilities test.
 *
 * @author johnniang
 * @date 3/26/19
 */
public class FilenameUtilsTest {

    // a/b/c.txt --> c.txt
    // a.txt     --> a.txt
    // a/b/c     --> c
    // a/b/c/    --> ""
    @Test
    public void getBasename() {
        assertThat(FilenameUtils.getBasename("a" + File.separatorChar + "b" + File.separatorChar + "c.txt"), equalTo("c"));
        assertThat(FilenameUtils.getBasename("a.txt"), equalTo("a"));
        assertThat(FilenameUtils.getBasename("a" + File.separatorChar + "b" + File.separatorChar + "c"), equalTo("c"));
        assertThat(FilenameUtils.getBasename("a" + File.separatorChar + "b" + File.separatorChar + "c" + File.separatorChar), equalTo(""));
    }

    // foo.txt      --> "txt"
    // a/b/c.jpg    --> "jpg"
    // a/b.txt/c    --> ""
    // a/b/c        --> ""
    @Test
    public void getExtension() {
        assertThat(FilenameUtils.getExtension("foo.txt"), equalTo("txt"));
        assertThat(FilenameUtils.getExtension("a" + File.separatorChar + "b" + File.separatorChar + "c.jpg"), equalTo("jpg"));
        assertThat(FilenameUtils.getExtension("a" + File.separatorChar + "b.txt" + File.separatorChar + "c"), equalTo(""));
        assertThat(FilenameUtils.getExtension("a" + File.separatorChar + "b" + File.separatorChar + "c"), equalTo(""));
        assertThat(FilenameUtils.getExtension("a" + File.separatorChar + "b" + File.separatorChar + "c" + File.separatorChar), equalTo(""));
    }
}
