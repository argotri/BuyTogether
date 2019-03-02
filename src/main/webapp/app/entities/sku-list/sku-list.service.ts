import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ISkuList } from 'app/shared/model/sku-list.model';

type EntityResponseType = HttpResponse<ISkuList>;
type EntityArrayResponseType = HttpResponse<ISkuList[]>;

@Injectable({ providedIn: 'root' })
export class SkuListService {
    public resourceUrl = SERVER_API_URL + 'api/sku-lists';

    constructor(protected http: HttpClient) {}

    create(skuList: ISkuList): Observable<EntityResponseType> {
        return this.http.post<ISkuList>(this.resourceUrl, skuList, { observe: 'response' });
    }

    update(skuList: ISkuList): Observable<EntityResponseType> {
        return this.http.put<ISkuList>(this.resourceUrl, skuList, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<ISkuList>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<ISkuList[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
