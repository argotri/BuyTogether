/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { BuyTogetherTestModule } from '../../../test.module';
import { SkuListDeleteDialogComponent } from 'app/entities/sku-list/sku-list-delete-dialog.component';
import { SkuListService } from 'app/entities/sku-list/sku-list.service';

describe('Component Tests', () => {
    describe('SkuList Management Delete Component', () => {
        let comp: SkuListDeleteDialogComponent;
        let fixture: ComponentFixture<SkuListDeleteDialogComponent>;
        let service: SkuListService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [BuyTogetherTestModule],
                declarations: [SkuListDeleteDialogComponent]
            })
                .overrideTemplate(SkuListDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(SkuListDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SkuListService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete', inject(
                [],
                fakeAsync(() => {
                    // GIVEN
                    spyOn(service, 'delete').and.returnValue(of({}));

                    // WHEN
                    comp.confirmDelete(123);
                    tick();

                    // THEN
                    expect(service.delete).toHaveBeenCalledWith(123);
                    expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                })
            ));
        });
    });
});
