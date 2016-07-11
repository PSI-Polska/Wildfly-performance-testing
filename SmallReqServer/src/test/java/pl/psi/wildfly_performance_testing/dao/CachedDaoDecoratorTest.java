package pl.psi.wildfly_performance_testing.dao;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Range;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import pl.psi.wildfly_performance_testing.model.WithK;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.T;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willAnswer;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by mblaszyk on 2016-07-08.
 */
public class CachedDaoDecoratorTest {


    // tuitak napisze mockiiii
    //// TODO: 2016-07-08 mbocian mocki

    public static final long TEST_ID_1 = 1;
    public static final long TEST_ID_2 = 2;
    public static final long TEST_ID_3 = 3;

    GenericDaoIf<WithK> genDaoMock;
    GenericDaoIf<WithK> testedCachedDao;

    @Before
    public void initTests(){
        genDaoMock  = mock(CoreDao.class);

        testedCachedDao = new CachedDaoDecorator(genDaoMock);
    }

    @Test
    public void shouldExecuteCreateInDaoTest(){
        WithK entityMock = mock(WithK.class);

        willAnswer(new Answer() {
            public Object answer(InvocationOnMock invocation) {
                Object[] args = invocation.getArguments();
                given(((WithK)args[0]).getId()).willReturn(TEST_ID_1); // that's the argument I want to modify
                return null;
            }}).given(genDaoMock).create(any(WithK.class));

        testedCachedDao.create(entityMock);

        verify(genDaoMock).create(entityMock);
        verify(entityMock).getId();
    }

    @Test
    public void CacheRemovePassTest(){

        WithK entityMock = mock(WithK.class);
        given(entityMock.getId()).willReturn(TEST_ID_1);
        willDoNothing().given(genDaoMock).remove(any(WithK.class));

        testedCachedDao.remove(entityMock);

        verify(genDaoMock).remove(entityMock);
        verify(entityMock).getId();

    }

    @Test
    public void CacheUpdatePassTest(){
        WithK entityMock = mock(WithK.class);
        given(entityMock.getId()).willReturn(TEST_ID_1);
        willDoNothing().given(genDaoMock).update(any(WithK.class));

        testedCachedDao.update(entityMock);

        verify(genDaoMock).update(entityMock);
        verify(entityMock).getId();
    }

    @Test
    public void CacheFindAllTest(){
        //setup
        WithK entityMock1 = mock(WithK.class);
        WithK entityMock2 = mock(WithK.class);
        WithK entityMock3 = mock(WithK.class);
        given(entityMock1.getId()).willReturn(TEST_ID_1);
        given(entityMock2.getId()).willReturn(TEST_ID_2);
        given(entityMock3.getId()).willReturn(TEST_ID_3);
        testedCachedDao.create(entityMock1);
        testedCachedDao.create(entityMock2);
        testedCachedDao.create(entityMock3);

        //test
        List<WithK> testedReturn = testedCachedDao.findAll();

        //verify
        assertEquals(testedReturn.size(),3);
        assertTrue(testedReturn.stream().anyMatch(item -> item.getId() == TEST_ID_1));
        assertTrue(testedReturn.stream().anyMatch(item -> item.getId() == TEST_ID_2));
        assertTrue(testedReturn.stream().anyMatch(item -> item.getId() == TEST_ID_3));


    }



    @Test
    public void CacheGetRandomEntityTest(){
        //setup
        WithK entityMock1 = mock(WithK.class);
        WithK entityMock2 = mock(WithK.class);
        WithK entityMock3 = mock(WithK.class);
        given(entityMock1.getId()).willReturn(TEST_ID_1);
        given(entityMock2.getId()).willReturn(TEST_ID_2);
        given(entityMock3.getId()).willReturn(TEST_ID_3);
        testedCachedDao.create(entityMock1);
        testedCachedDao.create(entityMock2);
        testedCachedDao.create(entityMock3);

        //test
        WithK testedReturn = testedCachedDao.getRandomEntity();

        //verify
        ImmutableList<Long> correctResults = ImmutableList.of(TEST_ID_1,TEST_ID_2,TEST_ID_3);
        assertTrue(correctResults.stream().anyMatch(item -> item == testedReturn.getId()));

    }






}