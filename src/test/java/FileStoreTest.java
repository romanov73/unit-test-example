import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.ulstu.entity.User;
import ru.ulstu.persistence.FileStore;
import ru.ulstu.persistence.PersistentStore;

import java.io.IOException;

@RunWith(PowerMockRunner.class)
public class FileStoreTest {

    private final PersistentStore<User> fileStore = new FileStore<>(User.class);

    @Before
    public void before() throws IOException {
        ((FileStore) fileStore).reset();
    }

    @Test
    public void saveNewUserToFileTest() throws IOException {
        User newUser = new User("");
        newUser = fileStore.save(newUser);
        Assert.assertEquals((long) newUser.getId(), 1L);
    }

    @After
    public void after() throws IOException {
        ((FileStore) fileStore).reset();
    }
}
